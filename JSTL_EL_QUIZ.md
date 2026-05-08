# JSTL & EL 학습 정리 퀴즈

오늘 학습한 JSTL(JSP Standard Tag Library)과 EL(Expression Language)의 핵심 내용을 복습해보세요.

---

## 1. EL (Expression Language) 기초

**Q1. EL에서 `request` 영역에 저장된 `name`이라는 속성값을 가져오는 올바른 문법은?**
- (1) `${request.name}`
- (2) `${requestScope.name}`
- (3) `<%= request.getAttribute("name") %>`
- (4) `${nameScope.request}`

**Q2. EL에서 영역(Scope)을 명시하지 않았을 때 (`${msg}` 처럼 사용 시), 데이터를 찾는 순서는 어떻게 되나요?**
- 답: `_____` -> `_____` -> `_____` -> `_____`

**Q3. 세션에 저장된 `user`라는 객체(DTO)의 `id` 필드 값을 EL로 출력하려면 어떻게 작성해야 하나요?**
- 답: `${____________________}`

---

## 2. JSTL Core 태그

**Q4. JSTL 변수를 선언하고 초기화하는 태그와 속성은 무엇인가요? (예: `num` 변수에 `100` 저장)**
- 답: `<c:___ var="___" value="___" />`

**Q5. `<c:out>` 태그를 사용하는 주요 이유 중 하나는 데이터가 없을 때 기본값을 설정하는 것입니다. 빈칸을 채우세요.**
- `<c:out value="${data}" default="__________" />`

**Q6. JSTL에서 '다중 조건문' (if-else if-else 와 유사한 구조)을 작성할 때 사용하는 태그 3가지는?**
- 답: `<c:______>`, `<c:____>`, `<c:_________>`

---

## 3. JSTL forEach & 반복문

**Q7. 1부터 10까지 2씩 증가하며 반복 출력하는 `forEach`문을 작성해보세요.**
- `<c:forEach var="i" begin="___" end="___" step="___"> ... </c:forEach>`

**Q8. `varStatus`를 사용할 때, 현재 반복문이 '첫 번째'인지 확인하는 속성과 '1부터 시작하는 순서'를 나타내는 속성은 각각 무엇인가요?**
- 첫 번째 확인: `status._____`
- 1부터 시작하는 순서: `status._____`

**Q9. 서블릿에서 `request`에 `list`라는 이름으로 저장된 리스트 데이터를 하나씩 꺼내어 `item`이라는 변수로 출력하는 문장을 작성하세요.**
- `<c:forEach var="item" items="${__________}"> ... </c:forEach>`

---

<details>
<summary><b>정답 확인 (클릭)</b></summary>

### 1. EL 기초
- **A1:** (2) `${requestScope.name}` (영역을 명시하는 것이 권장됨)
- **A2:** page -> request -> session -> application
- **A3:** `${sessionScope.user.id}` (또는 `${user.id}`)

### 2. JSTL Core 태그
- **A4:** `<c:set var="num" value="100" />`
- **A5:** `데이터 없음` (또는 원하는 기본 문구)
- **A6:** `<c:choose>`, `<c:when>`, `<c:otherwise>`

### 3. JSTL forEach & 반복문
- **A7:** `begin="1" end="10" step="2"`
- **A8:** `status.first`, `status.count`
- **A9:** `items="${requestScope.list}"` (또는 `items="${list}"`)

</details>
