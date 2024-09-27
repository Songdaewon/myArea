const $form = document.querySelector('#form');
const $result = document.querySelector('#result');
const $bonus = document.querySelector('#bonus');

$form.addEventListener('submit',(event)=>{
    event.preventDefault();

    //숫자 입력 예외처리
    const str = event.target.input.value;
    if(!str.trim()){  //아무 것도 입력하지 않을 시
        return alert('숫자를 입력하세요')
    }

    //str글자의 공백을 없애고 숫자로 전환한 것을 배열로 제작하고
    //,를 기준으로 나누어 배열에 저장
    const numbers = str.split(',').map((v)=>parseInt(v.trim()))
    if(numbers.length !==6){
        return alert('숫자 6개를 모두 입력하세요')
    }
    if(numbers.find((v) => v > 45 || v < 1)){
        return alert('1~45까지만 입력하세요')
    }
    if(new Set(numbers).size !== 6){
        return alert('숫자를 중복 없이 입력하세요')
    }

})
