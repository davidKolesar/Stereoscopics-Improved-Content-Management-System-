$(window).scroll(function() {
if ($(document).scrollTop() > 150) {
    alert('hi');
$('.logo').height(200);

}
else {
$('.logo').height(100);
});
