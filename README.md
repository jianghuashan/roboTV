# roboTV

roboTV is a Android TV based frontend for VDR.
Now you can use your Android TV Box (or your TV running Android) to stream LiveTV channels from your VDR backend (robotv-plugin must be installed).

## Screenshots

<img src="https://raw.githubusercontent.com/pipelka/roboTV/master/media/screenshots/livetv.jpg" width="200" />
<img src="https://raw.githubusercontent.com/pipelka/roboTV/master/media/screenshots/livetv-shortcuts.jpg" width="200" />
<img src="https://raw.githubusercontent.com/pipelka/roboTV/master/media/screenshots/livetv-timeshift.jpg" width="200" />
<img src="https://raw.githubusercontent.com/pipelka/roboTV/master/media/screenshots/epg.jpg" width="200" />
<img src="https://raw.githubusercontent.com/pipelka/roboTV/master/media/screenshots/epg-genre.jpg" width="200" />
<img src="https://raw.githubusercontent.com/pipelka/roboTV/master/media/screenshots/multiaudio.jpg" width="200" />
<img src="https://raw.githubusercontent.com/pipelka/roboTV/master/media/screenshots/homescreen.jpg" width="200" />
<img src="https://raw.githubusercontent.com/pipelka/roboTV/master/media/screenshots/movies-folders.jpg" width="200" />
<img src="https://raw.githubusercontent.com/pipelka/roboTV/master/media/screenshots/movies-all.jpg" width="200" />
<img src="https://raw.githubusercontent.com/pipelka/roboTV/master/media/screenshots/movies-details.jpg" width="200" />
<img src="https://raw.githubusercontent.com/pipelka/roboTV/master/media/screenshots/movies-playback.jpg" width="200" />
<img src="https://raw.githubusercontent.com/pipelka/roboTV/master/media/screenshots/setup.jpg" width="200" />

## System requirements

* [Android TV](https://www.android.com/tv/) (minimum API Level 22 Android 5.1 Lollipop)
* [VDR 2.2](http://www.vdr-wiki.de/)
* [vdr-plugin-robotv](https://github.com/pipelka/vdr-plugin-robotv)

The Google [Nexus Player](https://www.google.com/nexus/player/) and the NVIDIA [Shield Android TV](https://shield.nvidia.com/android-tv) are used for development.

## Building

1. Set the SDK and NDK location in Android Studio (Project Structure) or "local.properties".
   Please download the Android NDK 11 and set the proper path.
2. ./gradlew assembleDebug

# Current Features

- [x] Watching Live TV
- [x] Channel Icons
- [x] EPG
- [x] H264 Video support
- [x] MPEG2 Video support
- [x] decoding of AC3 streams
- [x] MPEG Audio support
- [x] Movie Database integration for EPG
- [x] AC3 passthrough
- [x] Watch Recordings
- [x] Timeshift support
- [x] Schedule Recordings (create timers)

# Planned Features

- [ ] Edit timers
- [ ] Delete recordings
- [ ] Move recordings between folders
- [ ] Teletext support
- [ ] Timeshift Reverse Play
- [ ] H265 (UHD) Support (partly done)
