# 📝 [JSP 실습 문제] 합격 여부 판별기 만들기

오늘 배운 JSP의 핵심 개념(데이터 수신, 로직 처리, Forward 이동)을 복습하기 위한 실습 문제입니다.

---

## 🎯 목표
사용자로부터 이름과 점수를 입력받아, 서버에서 합격 여부를 판별한 뒤 결과를 다른 페이지에 출력합니다.

## 📋 요구사항

### 1. `quiz_form.html` (입력 화면)
- 사용자에게 `이름(name)`과 `점수(score)`를 입력받는 폼을 만듭니다.
- **전송 방식(method)**: `POST`
- **대상(action)**: `quiz_process.jsp`

### 2. `quiz_process.jsp` (로직 처리)
- **한글 처리**: `request.setCharacterEncoding("UTF-8");`를 사용해 한글 깨짐을 방지합니다.
- **데이터 수신**: `request.getParameter()`로 이름과 점수를 받습니다.
- **로직 판별**: 
  - 점수가 **60점 이상**이면 `"합격"`, **60점 미만**이면 `"불합격"`을 변수에 저장합니다.
  - (참고: `Integer.parseInt()`를 사용해 문자열 점수를 숫자로 변환하세요.)
- **데이터 저장**: `request.setAttribute()`를 사용해 이름과 결과를 저장합니다.
- **페이지 이동**: **Forward 방식**을 사용하여 `quiz_result.jsp`로 이동합니다.

### 3. `quiz_result.jsp` (결과 출력)
- **데이터 추출**: `request.getAttribute()`를 사용하여 이름과 판별 결과를 가져옵니다.
- **화면 출력**: `OOO님은 이번 시험에서 [합격/불합격] 하셨습니다!` 문구를 출력합니다.

---

## 💡 힌트

- **문자열 -> 숫자 변환**: `int scoreNum = Integer.parseInt(request.getParameter("score"));`
- **Forward 사용법**:
  ```jsp
  <jsp:forward page="quiz_result.jsp" />
  ```
  또는 자바 코드로:
  ```java
  request.getRequestDispatcher("quiz_result.jsp").forward(request, response);
  ```

---

## ✅ 체크리스트
- [ ] POST 방식에서 한글 처리를 했는가?
- [ ] Forward 방식을 사용하여 주소창의 URL이 `quiz_process.jsp`에 머물러 있는가?
- [ ] `request` 영역을 통해 데이터를 성공적으로 전달했는가?
