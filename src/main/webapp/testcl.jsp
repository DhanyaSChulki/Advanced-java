<html>
<body>
<input type="text" id="dateField" placeholder="Click here">
<div id="simpleCal"></div>

<script>
document.getElementById('dateField').onclick = function() {
    let html = '<div style="border:2px solid blue;padding:10px;width:300px;background:white">';
    for(let i=1; i<=31; i++) {
        html += <span style="display:inline-block;width:30px;padding:5px;margin:2px;background:#eee;cursor:pointer" onclick="document.getElementById('dateField').value='2024-01-'+${i}; this.parentElement.style.display='none'">${i}</span>;
    }
    html += '</div>';
    document.getElementById('simpleCal').innerHTML = html;
}
</script>
</body>
</html>