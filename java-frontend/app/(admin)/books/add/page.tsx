'use client'
import { useApp } from "@/app/contexts/ApplicationContext"
import axios from "axios"
import { Button, Label, TextInput } from "flowbite-react"
import Link from "next/link"
import { useRouter } from "next/navigation"
import { use, useState } from "react"

const AddBook = () => {
  
    const {bookname, SetBookname, bookprice, SetBookprice, bookcost, SetBookcost, bookid, SetBookid} = useApp()
    const router = useRouter()
    const onSubmit = async (e:any)=>{
        e.preventDefault()
        if(bookname === null || bookprice === null || bookcost === null)
        {
          alert("Please fill all the fields with correct values")
          return
        }
        
        if(bookid)
        {
            axios.put(`http://localhost:8081/books/${bookid}`, {
                name: bookname,
                price: bookprice,
                cost: bookcost
            })
            .then(function (response) {
                console.log(response)
                alert("Book Modified successfully")
                SetBookname(null)
                SetBookprice(null)
                SetBookcost(null) 
                SetBookid(null)                       
            })
            .catch(function (error) {
                console.log(error);
            });
        }else{
            axios.post("http://localhost:8081/books", {
            name: bookname,
            price: bookprice,
            cost: bookcost
            })
            .then(function (response) {
                console.log(response)
                alert("Book added successfully")
                SetBookname(null)
                SetBookprice(null)
                SetBookcost(null)
                SetBookid(null)            
            })
            .catch(function (error) {
                console.log(error);
            });
        }
        
      }
  return (
    <>
      <div className="grid grid-cols-10">
      <p className="text-blue-600 hover:text-blue-700 underline font-bold hover:cursor-pointer w-auto" onClick={()=>router.back()}>Go back</p>
      </div>
      <form className="flex max-w-md flex-col gap-4 bg-white p-4 rounded mx-auto mt-16 ">
        <div>
          <div className="mb-2 block">
            <Label htmlFor="name" value="Book Name" />
          </div>
          <TextInput value={bookname??""} onChange={(e)=>SetBookname(e.target.value)} id="name" type="text" placeholder="" required />
        </div>

        <div>
          <div className="mb-2 block">
            <Label htmlFor="price" value="Book Price" />
          </div>
          <TextInput value={bookprice??""} onChange={(e)=>SetBookprice(+e.target.value)} type="number" required />
        </div>

        <div>
          <div className="mb-2 block">
            <Label htmlFor="cost" value="Book Cost" />
          </div>
          <TextInput value={bookcost??""} onChange={(e)=>SetBookcost(+e.target.value)} type="number" required />
        </div>
        <Button onClick={onSubmit} type="submit">Save Book</Button>
    </form>
    </>
  )
}
export default AddBook