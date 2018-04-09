## Synopsis

This is CK Metrices calculator plugin for Idea Intellij IDE. 
After installing this plugin a new option appears with name "CK Metrices" in the EditorPopupMenu.
Just right click from the java file where you want to see these values.
It will visualize the value of five metrics: 
LOC, LCOM, WMC, NOM, and CBO

If changes are done to the file, the visualization will change every 15 seconds.

## Creating the JAR

I am using gradle to build this project.
To run the code extract the zip file and open it as a Intellij plugin project.
On the command prompt run "./gradlew clean build" command from the root directory to crate the .jar file in the build.

## Installation

To install the plugin open the Idea Intellij preferences and select plugin option. 
Choose the option to add plugin from the disk and provide the JAR file.

## API Reference

I am using multiple libraries like: 'org.eclipse.jdt.core' to do computation about class dependencies.
I am using 'jfreechart' is used to do the visualization.

## References

I have used multiple open source to create this project like following:

1. IntelliJ Developer Documentation
2. mauricioaniche GitHub: https://github.com/mauricioaniche/ck/blob/master/pom.xml
3. MetricsReloaded GitHub: https://github.com/BasLeijdekkers/MetricsReloaded/blob/master/src/com/sixrr/metrics/plugin/ProjectMetricsAction.java
4. https://stackoverflow.com/questions/44061843/determining-the-efferent-coupling-between-objects-cbo-metric-using-the-parsed
5. https://stackoverflow.com/questions/49728829/how-to-share-an-intellij-plugin
6. https://stackoverflow.com/questions/49728829/how-to-share-an-intellij-plugin
7. https://stackoverflow.com/questions/7799940/jframe-exit-on-close-java#comment9502616_7800013
8. https://stackoverflow.com/questions/5522575/how-can-i-update-a-jfreecharts-appearance-after-its-been-made-visible


