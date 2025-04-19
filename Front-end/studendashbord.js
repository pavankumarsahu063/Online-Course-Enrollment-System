
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
            <button>Buy</button>
            
         `
         coursesContainer.append(courseDiv)
     })
     
 })