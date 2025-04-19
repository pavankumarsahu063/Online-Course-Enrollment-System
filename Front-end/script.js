const modal=document.getElementById("modal");
const loginModal=document.getElementById("login-modal");
document.getElementById("register").addEventListener("click",()=>{
    modal.style.display="block"
    loginModal.style.display="none"
})
document.querySelector(".close-btn").addEventListener("click",()=>{
    modal.style.display="none"
})
document.getElementById("login").addEventListener("click",()=>{
    loginModal.style.display="block"
     modal.style.display="none"
})
document.getElementById("login-modal-close").addEventListener("click",()=>{
    loginModal.style.display="none"
})




// Get all students
let allStudents = [];

document.addEventListener("DOMContentLoaded", async () => {
    try {
        const response = await fetch("http://localhost:8080/student/allstudents");
        allStudents = await response.json();
        console.log("All students loaded: ", allStudents);
    } catch (error) {
        console.error("Failed to fetch students:", error);
    }
});

const form=document.getElementById("form");
form.addEventListener("submit",async (e)=>{
    e.preventDefault();
    const studentData={
        name:document.getElementById("name").value,
        email:document.getElementById("email").value,
        phone:document.getElementById("number").value,
        password:document.getElementById("password").value
    }
    console.log(studentData)
    try{
        const response=await fetch("http://localhost:8080/student/register",{
            method:"POST",
            headers:{ 
            "content-type":"application/json"

            },
            body:JSON.stringify(studentData)
        })
        const messageContent=document.querySelector(".responseMessage");
        if(response.ok){
            const message=await response.text();
            messageContent.textContent=message;
            messageContent.style.color="green";
        }
        else{
            // const message=await response.text();
            messageContent.textContent="Error While Registering";
            messageContent.style.color="red";
            messageContent.style.textAlign = "center";

        }
        studentData={
            name:"",
            email:"",
            phone:"",
            password:""
        }
    }
    catch(e){
        console.log(e)
    }
})


