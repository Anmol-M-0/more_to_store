$(document).ready(function() {

  function removeClasses() {
    $('.object, .button').removeClass("expanded");
    $('.product').removeClass("transition");
  }

  function addClasses() {
    $('.object, .button').addClass("expanded");
    $('.product').addClass("transition");
  }
  $('html').on('DOMMouseScroll mousewheel', function expand(e) {
    if (e.originalEvent.detail > 0 || e.originalEvent.wheelDelta < 0) {
      console.log('down');
      addClasses();
    } else {

      removeClasses();
    }
  });
  
  $('.button').on('click', function(){
    if ( $('.button').hasClass('expanded')){
      removeClasses();
    } else {
    addClasses();
    }
  });

});