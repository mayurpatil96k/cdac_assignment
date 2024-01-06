function call(){
    let s=document.getElementById("pr");
    alert(s.nodeName);
    alert(s.childNodes[0].nodeValue);
    alert(s.childNodes[0].nodeName);
    alert(s.childNodes[0].nodeType);
}