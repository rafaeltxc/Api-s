## Usage
First, clone the repository:
```console
git clone https://github.com/rafaeltxc/Api-s
```
Once it's downloaded, build the project and find the *Connection.java* at the *connection package* in the source folder, in there, 
change the information of the constants *URL*, *USER* and *PASSWORD*, for you own database info.

The maven project already has the plugins for MySQL, but if you want to use another database, 
you will need to update the pom.xml for your prefered option.

The build and configurations being done, still in the source folder, the *vanillaJava package*, has the *App.java* class,
which is responsible for starting the app, and already has some data in it, so can start to use it right away.
