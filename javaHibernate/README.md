## Usage
First, clone the repository:
```console
git clone https://github.com/rafaeltxc/Api-s
```
Once it's downloaded, build the project and find the *Persistence.xml* in the *META-INF folder*, in there, 
change the information of the properties, for you own database info.

The maven project already has the plugins for MySQL and Hibernate, but if you want to use another database, 
you will need to update the pom.xml for your prefered option.

The build and configurations being done, in the source folder, the *hibernate package*, has the *App.java* class,
which is responsible for starting the app.
