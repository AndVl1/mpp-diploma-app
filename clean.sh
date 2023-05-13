#!/bin/sh
./gradlew clean
rm -rf .gradle
rm -rf build
rm -rf */build
rm -rf apps/iosApp/iosApp.xcworkspace
rm -rf apps/iosApp/Pods
rm -rf apps/iosApp/iosApp.xcodeproj/project.xcworkspace
rm -rf apps/iosApp/iosApp.xcodeproj/xcuserdata