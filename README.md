# ExoPlayer_Example_2marking

# 1. ExoPlayer
- Google에서 만든 오픈 소스 미디어 플레이 라이브러리
- 기존 MediaPlayer보다 작고 안정적으로 유연하게 사용이 가능하여 최근 많은 스트리밍 서비스 개발자들이 사용(속도, 안전성, 성능 측면)
- Youtube도 Exoplayer로 만들어졌으며 최근 다양한 서비스들에서 스트리밍이나 클립 영상들이 추가되면서 적용이 필요한 경우가 다수 발생

# 2. 지원 환경(Supported devices)

|제목|내용|설명|
|------|---|---|
|테스트1|테스트2|테스트3|
|테스트1|테스트2|테스트3|
|테스트1|테스트2|테스트3|

Use case	Android version number	Android API level
Audio playback	4.1	16
Video playback	4.1	16
DASH (no DRM)	4.1	16
DASH (Widevine CENC; “cenc” scheme)	4.4	19
DASH (Widevine CENC; “cbcs”, “cbc1” and “cens” schemes)	7.1	25
DASH (ClearKey)	5.0	21
SmoothStreaming (no DRM)	4.1	16
SmoothStreaming (PlayReady SL2000)	AndroidTV	AndroidTV
HLS (no DRM)	4.1	16
HLS (AES-128 encryption)	4.1	16
HLS (Widevine CENC; “cenc” scheme)	4.4	19
HLS (Widevine CENC; “cbcs” scheme)	7.1	25
For a given use case, we aim to support ExoPlayer on all Android devices that satisfy the minimum version requirement. Known device specific compatibility issues are listed below. Device specific issues on our GitHub issue tracker can be found here.

FireOS (version 4 and earlier) - Whilst we endeavour to support FireOS devices, FireOS is a fork of Android and as a result we are unable to guarantee support. Device specific issues encountered on FireOS are normally caused by incompatibilities in the support that FireOS provides for running Android applications. Such issues should be reported to Amazon in the first instance. We are aware of issues affecting FireOS version 4 and earlier. We believe FireOS version 5 resolved these issues.
Nexus Player (only when using an HDMI to DVI cable) - There is a known issue affecting Nexus Player, only when the device is connected to a monitor using a certain type of HDMI to DVI cable, which causes video being played too quickly. Use of an HDMI to DVI cable is not realistic for an end user setup because such cables cannot carry audio. Hence this issue can be safely ignored. We suggest using a realistic end user setup (e.g., the device connected to a TV using a standard HDMI cable) for development and testing.
Emulators - Some Android emulators do not properly implement components of Android’s media stack, and as a result do not support ExoPlayer. This is an issue with the emulator, not with ExoPlayer. Android’s official emulator (“Virtual Devices” in Android Studio) supports ExoPlayer provided the system image has an API level of at least 23. System images with earlier API levels do not support ExoPlayer. The level of support provided by third party emulators varies. Issues running ExoPlayer on third party emulators should be reported to the developer of the emulator rather than to the ExoPlayer team. Where possible, we recommend testing media applications on physical devices rather than emulators.
