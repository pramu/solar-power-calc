function load() {
	loadItem('header');
	loadItem('navigation');
	loadItem('footer');
}
function loadItem(e) {
	var url = 'snippets/' + e + '.html';
	injectElem(document.getElementById(e), url)
}
function injectElem(elem, url) {
	var xmlHttp = getXmlHttpRequest();
	xmlHttp.open("get", url, true);
	xmlHttp.onreadystatechange = function() {
		if (xmlHttp.readyState == 4) {
			elem.innerHTML = xmlHttp.responseText;
		}
	}
	xmlHttp.send(null);
}
function getXmlHttpRequest() {
	if (window.XMLHttpRequest) {
		return new XMLHttpRequest();
	}
	return new ActiveXObject("Microsoft.XMLHTTP");
}
