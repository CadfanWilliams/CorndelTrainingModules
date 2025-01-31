import './style.css'
import javascriptLogo from './javascript.svg'
import viteLogo from '/vite.svg'

document.getElementById("booksLink").onclick = fetchAllBooks;


function fetchAllBooks()
{
fetch("http://localhost:8080/books")
    .then(response => response.json())
    .then(data => setMyData(data));
}

function setMyData(data)
{
   const element = document.getElementById("books");
   for(const books of data)
   {
     var node = document.createElement("li");
     var textnode = document.createTextNode(JSON.stringify(books));
     node.appendChild(textnode);
     element.appendChild(node);
   }
}
