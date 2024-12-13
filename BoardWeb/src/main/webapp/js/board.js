/**
 *  js/board.js
 *  사용페이지: board.jsp
 */
console.log('start');


// 댓글 -> 삭제 -> retCode(OK, Fail)
function deleteReply(rno = 1){
	fetch('removeReply.do?rno='+rno)
	.then(result => result.json())
	.then(result => {
		console.log(result)
		if(result.retCode == 'OK'){
			alert("삭제완료.");
		document.querySelector('li[data-rno="' + rno + '"]').remove();			
		} else{
			alert("삭제가 안됨.");
		}
	})
	.catch(err => console.log(err))
}

// 댓글 등록 이벤트.
document.querySelector('#addBtn').addEventListener('click', function(e) {
    // 로그인정보, 원본글정보, 댓글내용.
	let reply = document.querySelector('#reply').value;
	// 필수항목 확인.
	if(logId == null || reply == null) {
		alert("필수입력값을 확인")
		return;
	}
	fetch('addReply.do?bno=' + bno + '&replyer=' + logId +'&reply='+reply) 	
	.then(result => result.json())
	.then(result => {
		console.log(result.retVal); // 결과확인. return:OK
		let reply = result.retVal;
		if(result.retCode == 'OK'){
			alert("등록성공");
			let html = `<li data-rno="${reply.replyNo}">
					         <span class="col-sm-2">${reply.replyNo}</span>
						     <span class="col-sm-5">${reply.reply}</span>
							 <span class="col-sm-2">${reply.replyer}</span>
							 <span class="col-sm-2"><button class="btn btn-danger" onclick="deleteReply(${reply.replyNo})">삭제</button></span>
								</li>`;
					let target = document.querySelector('div.reply ul.list');
					target.insertAdjacentHTML('afterbegin', html);
					document.querySelector('#reply').value= '';
		} else{
			alert("등록실패");
		}
	})
	.catch(err => console.log(err))
})


// 댓글목록 출력.
fetch('replyList.do?bno=' + bno)
.then(result => result.json())
.then(result => {
	console.log(result); // [{},{},{}]
	for(let reply of result) {
		let html = `<li data-rno="${reply.replyNo}">
		         <span class="col-sm-2">${reply.replyNo}</span>
			     <span class="col-sm-5">${reply.reply}</span>
				 <span class="col-sm-2">${reply.replyer}</span>
				 <span class="col-sm-2"><button class="btn btn-danger" onclick="deleteReply(${reply.replyNo})">삭제</button></span>
					</li>`;
		let target = document.querySelector('div.reply ul.list');
		target.insertAdjacentHTML('afterbegin', html);
	}
})
.catch(err => console.log(err));
