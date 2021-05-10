<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="myCarousel" class="carousel slide">
        <!-- Indicators -->
        <ol class="carousel-indicators">
            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
            <li data-target="#myCarousel" data-slide-to="1"></li>
            <li data-target="#myCarousel" data-slide-to="2"></li>
        </ol>
        <div class="carousel-inner">
            <div class="item active">
             
                <div class="fill" style="background-image:url('https://storiesflistgv2.azureedge.net/stories/2017/10/smartphonediwali_mainbanner.jpg');"></div>
                <div class="carousel-caption">
                    
                     <p class="animated fadeInUp">details</p>
                     <p class="animated fadeInUp"><a href="#" class="btn btn-transparent btn-rounded btn-large">More</a></p>
                </div>
            </div>
            <c:forEach items="${bannerList}" var="banner">
            <div class="item">
              
                <div class="fill" style="background-image:url('data:image/jpeg;base64,${banner.imgUtility}');"></div>
                <div class="carousel-caption">
                     <p class="animated fadeInUp">details</p>
                     <p class="animated fadeInUp"><a href="#" class="btn btn-transparent btn-rounded btn-large">More</a></p>
                </div>
            </div>
            </c:forEach>
            
      
        </div>
        <a class="left carousel-control" href="#myCarousel" data-slide="prev">
            <span class="icon-prev"></span>
        </a>
        <a class="right carousel-control" href="#myCarousel" data-slide="next">
            <span class="icon-next"></span>
        </a>

    </div>
