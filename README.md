## How to depend on GPUCloudSimPlus

Install [JDK 17](https://www.oracle.com/java/technologies/downloads/#java17)
and [Apache Maven](https://maven.apache.org/install.html) according to instructions. Make sure to update the `JAVA_HOME`
or `PATH` variables as mentioned in the installation instructions or `mvn` commands will not work.

Clone this repository and open command prompt, navigating to the directory hosting the cloned repository. Use
the `mvn install` command to install GPUCloudSimPlus to your local Maven repository.

To use GPUCloudSimPlus in another project, create a Maven project (most IDEs for Java support this) and add the
following to the `dependencies` section of the `pom.xml` file:

```xml

<dependency>
    <groupId>org.gpucloudsimplus</groupId>
    <artifactId>gpucloudsimplus</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <scope>compile</scope>
</dependency>
```

An example build section of the `pom.xml` to properly shade GPUCloudSimPlus into your project is:

```xml

<build>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-compiler-plugin</artifactId>
            <version>3.8.1</version>

            <configuration>
                <source>17</source>
                <target>17</target>
            </configuration>
        </plugin>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-shade-plugin</artifactId>
            <version>3.5.0</version>
            <configuration>
                <minimizeJar>false</minimizeJar>
                <filters>
                    <filter>
                        <artifact>org.gpucloudsimplus:gpucloudsimplus</artifact>
                        <includes>
                            <include>**</include>
                        </includes>
                    </filter>
                </filters>
            </configuration>
            <executions>
                <execution>
                    <phase>package</phase>
                    <goals>
                        <goal>shade</goal>
                    </goals>
                </execution>
            </executions>
        </plugin>
    </plugins>
</build>
```

## Fixed issues

This fork of GPUCloudSimPlus solves the following issues from
the [original repository](https://github.com/ImMohammadHosseini/GpuCloudsimPlus):

* Compile time errors (final variables unassigned)
* Runtime errors
    * Simulation is null
    * Simulation must be started before adding PEs
* Updated CloudSim Plus to version 8.0.0
* Maven dependency management errors