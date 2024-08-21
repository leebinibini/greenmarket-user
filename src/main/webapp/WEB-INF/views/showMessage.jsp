<%@page language="java" contentType="text/html;charset=UTF-8"%>
<html>
<head>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <title>쇼메세지</title>
</head>
<body>
<div class="container-fluid">
    <div class="main h-100"> <!--옆으로 창의 사이즈를 움직여도 화면이 깨지지 않음 -->
        <div class="row justify-content-center mt-5">
            <div class="col-4 text-center">
                <h1>${message}</h1> <!--모델(자바에서 jsp로 넘어갈 때 사용하는 클래스)에서 넘어온 값은 이렇게 표시해줄 수 있음 $ -->
            </div>
        </div>
      <div class="row justify-content-center">
            <div class="col-6 text-center btn btn-outline-danger" onclick="javascript:history.go(-1)">뒤로가기</div>
        </div>
    </div>
</div>
</body>

</html>