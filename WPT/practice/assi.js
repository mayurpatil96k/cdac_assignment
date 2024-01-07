function color() {
    var a = document.getElementsByName('rd');
    var b= document.getElementById("trg");
    for (var i = 0; i < a.length; i++) {
        if (a[i].checked) {  
            if(a[i].value=='RED'){
                b.classList.remove('c1', 'c2', 'c3');
                b.classList.add('c1');
            }
            if(a[i].value=='ORANGE'){b.classList.remove('c1', 'c2', 'c3');
                b.classList.add('c2');
            }
            if(a[i].value=='AQUAMARINE'){
                b.classList.remove('c1', 'c2', 'c3');
                b.classList.add('c3');
            }
        }
    }
}
