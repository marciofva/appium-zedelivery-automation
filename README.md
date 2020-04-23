# Mobile Automation
---

Zé delivery app E2E testing project

## Pre-requisites:

- MacOS (latest)
- Node
- Java (v8)
- Appium 
- Appium Doctor
- Maven


---

### Setup the environment variables:

Open `.bash_profile`

```
vim ~/.bash_profile
```

Add the following lines to the opened file:

```
export JAVA_HOME=$(/usr/libexec/java_home)
export PATH=$PATH:$JAVA_HOME
export PATH=$PATH:$JAVA_HOME/bin

export ANDROID_HOME=/Users/your_username/Library/Android/sdk
export PATH=$ANDROID_HOME/platform-tools:$PATH
export PATH=$ANDROID_HOME/tools:$PATH
export PATH=$ANDROID_HOME/lib:$PATH
export PATH=$ANDROID_HOME/emulator:$PATH
export PATH=$ANDROID_HOME/tools/lib:$PATH
```

Save and run `source` to apply the changes to your current session

```
source ~/.bash_profile
```


### Checking Appium dependencies

Run in terminal:

```
appium-doctor
```

The output should contain something like this:

```
info AppiumDoctor Appium Doctor v.1.6.0
info AppiumDoctor ### Diagnostic starting ###
info AppiumDoctor  ✔ The Node.js binary was found at: /usr/local/bin/node
info AppiumDoctor  ✔ Node version is 11.14.0
info AppiumDoctor  ✔ Xcode is installed at: /Applications/Xcode.app/Contents/Developer
info AppiumDoctor  ✔ Xcode Command Line Tools are installed.
info AppiumDoctor  ✔ DevToolsSecurity is enabled.
info AppiumDoctor  ✔ The Authorization DB is set up properly.
info AppiumDoctor  ✔ Carthage was found at: /usr/local/bin/carthage
info AppiumDoctor  ✔ HOME is set to: /Users/...
info AppiumDoctor  ✔ ANDROID_HOME is set to: /Users/.../Library/Android/sdk
info AppiumDoctor  ✔ JAVA_HOME is set to: /Library/Java/JavaVirtualMachines/jdk1.8.0_161.jdk/Contents/Home
info AppiumDoctor  ✔ adb exists at: /Users/.../Library/Android/sdk/platform-tools/adb
info AppiumDoctor  ✔ android exists at: /Users/.../Library/Android/sdk/tools/android
info AppiumDoctor  ✔ emulator exists at: /Users/.../Library/Android/sdk/tools/emulator
info AppiumDoctor  ✔ Bin directory of $JAVA_HOME is set
info AppiumDoctor ### Diagnostic completed, no fix needed. ###
info AppiumDoctor
info AppiumDoctor Everything looks good, bye!
info AppiumDoctor
```


### Starting android device

- Connect a real device or open an android emulator 

- Make sure *Zé Delivery App* is already installed in the device or/and emulator


### Starting the Appium server

Run in terminal:

```
appium
```


### Running android test suite


```
mvn clean test -DsuiteXmlFile=test-suites/AndroidSuite.xml
```

