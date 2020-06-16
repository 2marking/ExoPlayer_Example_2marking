# ExoPlayer_Example_2marking

# 1. ExoPlayer
- Google에서 만든 오픈 소스 미디어 플레이 라이브러리
- 기존 MediaPlayer보다 작고 안정적으로 유연하게 사용이 가능하여 최근 많은 스트리밍 서비스 개발자들이 사용(속도, 안전성, 성능 측면)
- Youtube도 Exoplayer로 만들어졌으며 최근 다양한 서비스들에서 스트리밍이나 클립 영상들이 추가되면서 적용이 필요한 경우가 다수 발생

# 2. 지원 환경(Supported devices)

|Use case|Android version number|Android API level|
|------|---|---|
|Audio playback|4.1|16|
|Video playback|4.1|16|
|DASH (no DRM)|4.1|16|
|DASH (Widevine CENC; “cenc” scheme)|4.4|19|
|DASH (Widevine CENC; “cbcs”, “cbc1” and “cens” schemes)|7.1|25|
|DASH (ClearKey)|5.0|21|
|SmoothStreaming (no DRM)|4.1|16|
|SmoothStreaming (PlayReady SL2000)|AndroidTV|AndroidTV|
|HLS (no DRM)|4.1|16|
|HLS (AES-128 encryption)|4.1|16|
|HLS (Widevine CENC; “cenc” scheme)|4.4|19|
|HLS (Widevine CENC; “cbcs” scheme)|7.1|25|

특정 사용 사례의 경우, 최소 버전 요구 사항을 충족하는 모든 Android 기기에서 ExoPlayer를 지원한다. 레퍼런스에서 제공하는 Android 버전별 호환성 표는 위와 같다.

FireOS (버전 4 이하)
- FireOS 장치를 지원하기 위해 노력하는 동안 FireOS는 Android의 포크이므로 지원을 보장할 수 없다. FireOS에서 발생하는 기기별 문제는 일반적으로 FireOS가 Android 애플리케이션을 실행하기 위해 제공하는 지원의 비호환성으로 인해 발생한다. 이러한 문제는 Amazon에 오류 보고 및 수정을 진행해야 한다. 최근에는 FireOS 5가 이러한 문제를 해결했다.

Nexus Player (HDMI to DVI 케이블을 사용하는 경우에만 해당)
- Nexus Player에 영향을 미치는 알려진 문제가 있다. 특정 유형의 HDMI-DVI 케이블을 사용하여 기기를 모니터에 연결 한 경우에만 비디오가 너무 빨리 재생된다. 최종 사용자 설정에는 오디오를 전송할 수 없기 때문에 HDMI-DVI 케이블을 사용하는 것이 좋지 않다. 따라서 이 문제는 무시해도 된다. 개발 및 테스트를 위해 현실적인 최종 사용자 설정(예 : 표준 HDMI 케이블을 사용하여 TV에 연결된 장치)을 사용하는 것이 좋다.

Emulator
- 일부 Android 에뮬레이터는 Android 미디어 스택의 구성 요소를 올바르게 구현하지 않으므로 결과적으로 ExoPlayer를 지원하지 않는다. 이것은 ExoPlayer가 아닌 에뮬레이터의 문제로 시스템 이미지의 API 수준이 23 이상인 경우 Android의 공식 에뮬레이터(Android Studio의 "가상 장치")는 ExoPlayer를 지원한다. 이전 API 수준의 시스템 이미지는 ExoPlayer를 지원하지 않는다. 타사 에뮬레이터가 제공하는 지원 수준은 다양하며 타사 에뮬레이터에서 ExoPlayer를 실행하는 문제는 ExoPlayer팀이 아닌 에뮬레이터 개발자에게 오류보고 및 수정을 요청해야 한다. 그래서 가능하다면 에뮬레이터가 아닌 실제 디바이스에서 테스팅을 진행하는 것이 좋다.

출처 : ExoPlayer 레퍼런스 문서 https://exoplayer.dev/supported-devices.html

# 3. 최신 버전 체크(Release Notes)

최신 버전 : 2.11.5 (2020-06-05)

확인 링크 : https://github.com/google/ExoPlayer/blob/release-v2/RELEASENOTES.md

# 4. 참고 자료

Java Doc : https://exoplayer.dev/doc/reference/

# 5. ExoPlayer_Example_2marking 샘플 앱 실행 
