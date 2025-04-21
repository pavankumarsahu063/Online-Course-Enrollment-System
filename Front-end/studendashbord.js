
const coursesContainer=document.querySelector(".course-container");

document.addEventListener("DOMContentLoaded",async ()=>{
     const response=await fetch("http://localhost:8080/course/allcourses");
     const data=await response.json();
     console.log(data)


     data.forEach((course)=>{

         const courseDiv=document.createElement("div");
         courseDiv.className="course";

         courseDiv.innerHTML+=`


            <h1>${course.title}</h1>
            <h1>${course.category}</h1>
            <h1>${course.instructor}</h1>
            <p>${course.description}</p>
            <p>Duration: ${course.duration}</p>
            <button class="buy-btn">Buy</button>
            
         `
         coursesContainer.append(courseDiv)
     })

     courseDiv.querySelector("buy-btn").addEventListener("click",async ()=>{
        const response=await fetch("http://localhost:8080/course/buy",{
            method:"POST",
            headers:{
                "content-type":"application/json",

            },
            body:JSON.stringify(course)
        });

        if(response.ok){
            alert("Cource Bought Sucessfully");
        }
        else{
            alert("something went wrong");
        }
     })
     
 })