'use client'
import { fetcher } from "@/app/components/Functions/Fetcher";
import MyLoading from "@/app/components/MyLoading";
import axios from "axios";
import { Table, TableBody, TableCell, TableHead, TableHeadCell, TableRow } from "flowbite-react"
import useSWR, { mutate } from "swr";

const Customers = () => {
    const link = "http://localhost:8081/users-detail";
    const { data, error, isLoading } = useSWR(link, () => fetcher(link));
    
    if(error) return <div>failed to load</div>
    if(isLoading) return (<MyLoading />)
    if(!data) return <div>no data</div> 
    // console.log(data[0].user)
  return (
    <div className="p-2">

    <div className="overflow-x-auto mt-3">
      <Table hoverable>
        <TableHead>
          <TableHeadCell>Name</TableHeadCell>
          <TableHeadCell>Email</TableHeadCell>
          <TableHeadCell>Phone</TableHeadCell>
          <TableHeadCell>DOB</TableHeadCell>
          <TableHeadCell>
            <span className="sr-only">Delete</span>
          </TableHeadCell>
        </TableHead>

        <TableBody className="divide-y">

        {data.map((customer:any)=>(
          <TableRow key={customer.id} onClick={()=>console.log(customer.id)} className="hover:cursor-pointer bg-white dark:border-gray-700 dark:bg-gray-800">
            <TableCell className="whitespace-nowrap font-medium text-gray-900 dark:text-white">
            {customer.name}
            </TableCell>
            <TableCell>{customer.user?.email}</TableCell>
            <TableCell>{customer.phone}</TableCell>
            <TableCell>{customer.dob}</TableCell>
            <TableCell>
              <a href="#" className="font-medium text-cyan-600 hover:underline dark:text-cyan-500" onClick={()=>{
                 axios.delete(`${link}/${customer.id}`).then(response => {
                  mutate(link)
                  alert('Customer deleted successfully')
                 }).catch(error => {
                  console.error(error);
                });
                 
              }}>
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
export default Customers