//Dsashboeard Data
const coursesContainer=document.getElementById("dashboard");
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

         courseDiv.querySelector(".buy-btn").addEventListener("click",()=>{
                alert(course.id)
         })
     })
 });


document.addEventListener("DOMContentLoaded", function() {    
    document.getElementById('student-name').textContent = '';
    showSection('dashboard');
  });
  function showSection(section) {
    const sections = document.querySelectorAll('.content-section');
    sections.forEach(sec => sec.style.display = 'none'); 
    const activeSection = document.getElementById(section);
    if (activeSection) {
      activeSection.style.display = 'block';
    }
  }


const loadUser= async () => {

    try {
        const response = await fetch("http://localhost:8080/student/currentuser");

        if (!response.ok) {
            console.log("Failed to fetch current user");
        }

        let data = await response.json();
        console.log(data); 

        let profileContainer=document.createElement("div");
        profileContainer.className="profile-div";

        profileContainer.innerHTML=`
        <h1>Name:${data.name}</h1>
        <h1>Email:${data.email}</h1>
        <h1>Phone:${data.phone}</h1>

        <button>Edit</button>
        
        `
        document.getElementById("profile").append(profileContainer)
        
    } catch (error) {
        console.error(error);
    }
}