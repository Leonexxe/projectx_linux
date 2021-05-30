#include <iostream>
#include <string>
#include "projectX/core/core.cpp"
#include <projectX/PLATFORM.cpp>
/**
 * @brief main function, litterally just creates a new core and calls the initiate function of said core.
 * 
 * @return int 
 */
int main(int argc, char *argv[])
{
    core CORE;
    return CORE.initiate();
}
