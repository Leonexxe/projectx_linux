package audio;
/*////////////////////////////////////////////////////////////////////////////////////////////////////*/
//
//projectX classes
//
/*////////////////////////////////////////////////////////////////////////////////////////////////////*/

/*////////////////////////////////////////////////////////////////////////////////////////////////////*/
//
//external classes
//
/*////////////////////////////////////////////////////////////////////////////////////////////////////*/
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.Mixer;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.TargetDataLine;

public class audio {
    boolean stopCapture = false;
    ByteArrayOutputStream byteArrayOutputStream;
    AudioFormat audioFormat;
    TargetDataLine targetDataLine;
    AudioInputStream audioInputStream;
    BufferedOutputStream out = null;
    BufferedInputStream in = null;
    Socket sock = null;
    SourceDataLine sourceDataLine;
    
    public static void main(String[] args) {
        audio tx = new audio();
        tx.captureAudio();
    }
    
    private void captureAudio() {
        try {
            sock = new Socket("192.168.178.50", 5000); 
            out = new BufferedOutputStream(sock.getOutputStream());
            in = new BufferedInputStream(sock.getInputStream());
    
            Mixer.Info[] mixerInfo = AudioSystem.getMixerInfo();
            System.out.println("Available mixers:");
            for (int cnt = 0; cnt < mixerInfo.length; cnt++) {
                System.out.println(mixerInfo[cnt].getName());
            }
    
            DataLine.Info dataLineInfo = new DataLine.Info(TargetDataLine.class, getAudioFormat());
    
            Mixer mixer = AudioSystem.getMixer(mixerInfo[0]);
    
            targetDataLine = (TargetDataLine) mixer.getLine(dataLineInfo);
    
            targetDataLine.open(audioFormat);
            targetDataLine.start();
    
            Thread captureThread = new CaptureThread();
            captureThread.start();
    
            DataLine.Info dataLineInfo1 = new DataLine.Info(
                    SourceDataLine.class, audioFormat);
            sourceDataLine = (SourceDataLine) AudioSystem
                    .getLine(dataLineInfo1);
            sourceDataLine.open(audioFormat);
            sourceDataLine.start();
    
            Thread playThread = new PlayThread();
            playThread.start();
    
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    } 
    class CaptureThread extends Thread {
    
        byte tempBuffer[] = new byte[10000];
    
        @Override
        public void run() {
            byteArrayOutputStream = new ByteArrayOutputStream();
            stopCapture = false;
            try {
                while (!stopCapture) {
    
                    int cnt = targetDataLine.read(tempBuffer, 0,
                            tempBuffer.length);
    
                    out.write(tempBuffer);
    
                    if (cnt > 0) {
    
                        byteArrayOutputStream.write(tempBuffer, 0, cnt);
    
                    }
                }
                byteArrayOutputStream.close();
            } catch (Exception e) {
                System.out.println(e);
                System.exit(0);
            }
        }
    }
    
    private AudioFormat getAudioFormat() {
        float sampleRate = 44100F;
    
        int sampleSizeInBits = 16;
    
        int channels = 2;
    
        boolean signed = true;
    
        boolean bigEndian = false;
    
        return new AudioFormat(sampleRate, sampleSizeInBits, channels, signed,
            bigEndian);
    }
    class PlayThread extends Thread {
        
        byte tempBuffer[] = new byte[10000];
        
        @Override
        public void run() {
            try {
                while (in.read(tempBuffer) != -1) {
                    sourceDataLine.write(tempBuffer, 0, 10000);
        
                }
                sourceDataLine.drain();
                sourceDataLine.close();
        
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
