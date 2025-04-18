const modal=document.getElementById("modal");


document.getElementById("register").addEventListener("click",()=>{
    modal.style.display="block"
})
document.querySelector(".close-btn").addEventListener("click",()=>{
    modal.style.display="none"
})