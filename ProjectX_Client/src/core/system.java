package core;

import log.log;
@SuppressWarnings("all")
public class system {

      private log Log = null;
      public Client client = null;

      public fileSystem FileSystem = new fileSystem(this);

      public system(Client client) {
            this.client = client;
      }
}
