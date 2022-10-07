fastlane documentation
================
# Installation

Make sure you have the latest version of the Xcode command line tools installed:

```
xcode-select --install
```

Install _fastlane_ using
```
[sudo] gem install fastlane -NV
```
or alternatively using `brew cask install fastlane`

# Available Actions
## Android
### android ktlintFormat
```
fastlane android ktlintFormat
```
KtlintFormat
### android ktlintCheck
```
fastlane android ktlintCheck
```
KtlintCheck
### android detekt
```
fastlane android detekt
```
detekt
### android spotlessCheck
```
fastlane android spotlessCheck
```
spotlessCheck
### android spotlessApply
```
fastlane android spotlessApply
```
spotlessApply
### android jacocoTestReport
```
fastlane android jacocoTestReport
```
jacocoTestReport

----

This README.md is auto-generated and will be re-generated every time [fastlane](https://fastlane.tools) is run.
More information about fastlane can be found on [fastlane.tools](https://fastlane.tools).
The documentation of fastlane can be found on [docs.fastlane.tools](https://docs.fastlane.tools).
