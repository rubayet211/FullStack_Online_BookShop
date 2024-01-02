'use client'
import { fetcher } from "@/app/components/Functions/Fetcher";
import MyLoading from "@/app/components/MyLoading";
import { Button } from "flowbite-react"
import { Table, TableBody, TableCell, TableHead, TableHeadCell, TableRow } from 'flowbite-react';
import Image from 'next/image'
import useSWR, { mutate } from "swr";
import axios from 'axios';
import { useRouter } from "next/navigation";
import { useApp } from "@/app/contexts/ApplicationContext";

const Books = () => {
  const {bookname, SetBookname, bookprice, SetBookprice, bookcost, SetBookcost, SetBookid} = useApp()
  const router = useRouter()
    const link = "http://localhost:8081/books";
  const { data, error, isLoading } = useSWR(link, () => fetcher(link));
    console.log(data)


    if(error) return <div>failed to load</div>
    if(isLoading) return (<MyLoading />)
    if(!data) return <div>no data</div> 

    const deleteBook = async (id:number) =>{
        console.log(id);

        axios.delete(`${link}/${id}`)
        .then(response => {
            mutate(link)
            alert('Book deleted successfully')
            console.log(`Deleted post with ID ${id}`);

        })
        .catch(error => {
            console.error(error);
        });
        
    }   
 

  return (
    <div className="p-2">
        <Button onClick={()=>router.push('/books/add')}>Add new book</Button>

    <div className="overflow-x-auto mt-3">
      <Table hoverable>
        <TableHead>
          <TableHeadCell>Book name</TableHeadCell>
          <TableHeadCell>Cost</TableHeadCell>
          <TableHeadCell>Price</TableHeadCell>
          <TableHeadCell>Cover</TableHeadCell>
          <TableHeadCell>
            <span className="sr-only">Edit</span>
          </TableHeadCell>
          <TableHeadCell>
            <span className="sr-only">Delete</span>
          </TableHeadCell>
        </TableHead>

        <TableBody className="divide-y">

        {data.map((book:any)=>(
          <TableRow key={book.id} onClick={()=>console.log(book.id)} className="hover:cursor-pointer bg-white dark:border-gray-700 dark:bg-gray-800">
            <TableCell className="whitespace-nowrap font-medium text-gray-900 dark:text-white">
            {book.name}
            </TableCell>
            <TableCell>{book.cost}</TableCell>
            <TableCell>{book.price}</TableCell>
            <TableCell>
                <Image 
                src='/cover.jpg'
                alt="Picture of Book Store" 
                width={60}
                height={100}
                />
            </TableCell>
            <TableCell>
              <a className="font-medium text-cyan-600 hover:underline dark:text-cyan-500" onClick={()=>{
                  SetBookname(book.name)
                 SetBookcost(book.cost)
                  SetBookprice(book.price)
                  SetBookid(book.id)
                  router.push('/books/add')
              }}>
                Edit
              </a>
            </TableCell>
            <TableCell>
              <a href="#" className="font-medium text-cyan-600 hover:underline dark:text-cyan-500" onClick={()=>deleteBook(book.id)}>
                Delete
              </a>
            </TableCell>
          </TableRow>
        ))}
          
        </TableBody>
      </Table>
    </div>
    </div>
  )
}
export default Books