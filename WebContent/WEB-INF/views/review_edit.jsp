
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
   
<%@ taglib prefix="c" uri= "http://java.sun.com/jsp/jstl/core" %>



<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="description" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <!-- Favicon -->
    <link rel="icon" href="img/core-img/favicon.ico">

    <!-- Core Stylesheet -->
    <link href="style.css" rel="stylesheet">

    <!-- Responsive CSS -->
    <link href="css/responsive/responsive.css" rel="stylesheet">


    <!-- <script type="text/javascript" src="../ckeditor/ckeditor.js" ></script>
   <link rel="Stylesheet" href="../style/default.css" /> -->
   
   
   <!-- include libraries(jQuery, bootstrap) -->
   <!-- <link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
  
   <script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script>  -->
   

   
   <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />
 
   <script src="https://cdn.ckeditor.com/ckeditor5/11.0.1/classic/ckeditor.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <SCRIPT type="text/javascript">
    
    
	window.onload=function(){
		
	    //미리보기 부분 
	    var file = document.querySelector('#filename');
 
	    file.onchange = function () { 
	    var fileList = file.files ;
	    
	    // 읽기
	    var reader = new FileReader();
	    reader.readAsDataURL(fileList [0]);

	    //로드 한 후
	    reader.onload = function  () {
	        document.querySelector('#previewImage').src = reader.result ;
	    }; 
	}; 
		
};


    
	function editclick(){
    if($('#title')==null){
        alert("제목을 입력하세요");
        $('#title').focus();
        return false;
    }
    if($('#content')==null){     
        alert("내용을 입력하세요");
        $('#content').focus();
        return false;
    }

    $('#editbtn').submit();
}

</SCRIPT>  
</HEAD>

<style>

button {
   background-color: #341a79;
}

section {
   padding-top: 200px;
}

h5, h6 {
   text-align: left;
}

p {
   text-align: left;
}

article {
   margin-bottom: 10%;
}

.left {
	width: 20%;
}

.right {
	width: 80%;
}
</style>

<body>


<jsp:include page="/common/top.jsp"></jsp:include>
<div class="breadcumb-area bg-img bg-overlay" style="background-image: url(img/bg-img/hero.jpg)">

<script type="text/javascript">
</script>
   <section>
      <article class="container" style="height: 90%;">
         <div class="animatedParent" id="myString">
            <div class="section-heading text-center animated fadeInDown">
               <h2 class="h-bold">
                  <i class="fas fa-edit"></i>&nbsp;&nbsp;Review Edit
               </h2>
            </div>
         </div>


<c:set var="review" value="${requestScope.reviewedit}"></c:set>
<script type="text/javascript">
console.log(${review.fidx});
console.log(${review.savename});
</script>
         <div id="writeForm" class="col-sm-12" style="height: 80%;">
           

            <div class="row">
               <div class="col-md-2"></div>
               <div class="col-md-8">
                  <form action="ReviewEditOk.do?bcode=202&tcode=0&cp=${requestScope.cp}&ps=${requestScope.ps}&idx=${requestScope.idx}&fidx=${review.fidx}" method="post" name="review" id="review" enctype="multipart/form-data">
                     <table class="table">
                        <tr>
                           <td><h6>Title</h6></td>
                           <td><input type="text" class="form-control" name="title" id="title" value="${review.title}"></td>
                        </tr>
                        
                          <tr>
                           <td><h6>Writer</h6></td>  
                           <td><input type="text" class="form-control" name="id" id="id" value="${review.id}" readonly></td>
                        </tr>

                        <tr>
                           <td><h6>Content</h6></td>
                           <td><textarea rows="100" cols="100" name="content" id="content" class="form-control ckeditor" style="height:500; overflow:visible;" value="${review.content}">${review.content}</textarea></td>
                        </tr>

                        <tr>
                           <td><h6>File</h6></td>
                           <td><input type="file" name="filename" value="${review.savename}">
                           <img id="previewImage" src="upload/${review.savename}" width="100" alt="로컬에 있는 이미지가 보여지는 영역" onerror="this.src='./img/bg-img/error.png'">
							</td>
                        </tr>
                        <tr>
                        
						<tr>
                           <td colspan="2" class="text-center">
                              <button type=submit id="editbtn" class="btn dorne-btn" style="width: 200px;" onclick="editclick()" >
                                 <i class="far fa-check-circle"></i>&nbsp;&nbsp;수정하기
                              </button>
                              <a href="ReviewList.do?bcode=202&tcode=0"><button type="button" class="btn dorne-btn">목록으로</button></a>
                           </td>
                        </tr>

                     </table>
                  </form>
               </div>
            </div>

         </div>

      </article>
   </section>

   </body>
   <jsp:include page="/common/bottom.jsp"></jsp:include>
   
       <script>
    ClassicEditor
        .create( document.querySelector( '#content' ) );
       
    </script>
</html>