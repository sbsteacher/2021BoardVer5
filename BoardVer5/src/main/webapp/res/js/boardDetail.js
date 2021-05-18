var insFrmElem = document.querySelector('#insFrm');
var updFrmElem = document.querySelector('#updFrm');

//댓글 삭제
function delCmt(iboard, icmt) {
	console.log('iboard: %d, icmt: %d', iboard, icmt);
		
	if(confirm('삭제하시겠습니까?')) {
		location.href = `/board/cmt?icmt=${icmt}&iboard=${iboard}`;	
	}
}

//댓글 수정
function updCmt(icmt, cmt) {	
	console.log('icmt : %s', icmt);
	console.log('cmt : %s', cmt);
	updFrm.icmt.value = icmt;
	updFrm.cmt.value = cmt;
	
	insFrm.className = 'hidden';
	updFrm.className = '';
}


function showInsFrm() {	
	insFrm.className = '';
	updFrm.className = 'hidden';
}




