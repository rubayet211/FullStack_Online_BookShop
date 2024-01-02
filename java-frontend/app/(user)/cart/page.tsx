'use client'
import Navbar  from "@/app/components/Navbar"
import { Button } from "flowbite-react";
import Image from 'next/image'
import useSWR from "swr";

const link = "http://localhost:3333/books";
const fetcher = () => fetch(link).then(res => res.json())


const Cart = () => {
    
    const { data, error, isLoading } = useSWR(link, fetcher)
    console.log(data)

    if(error) return (<div>failed to load</div>)
    if(isLoading) return <div>loading...</div>

    if(!data) return <div>no data</div>  

    return (
    <div className="flex w-full mt-4">
        <div className="w-1/2 border-r border-black p-3">
            {data.map((book:any) => (
                
                <div className="w-4/5 mb-3 flex bg-white hover:bg-orange-100 gap-8 items-center rounded">
                    <div className="bg-cover h-28 w-24 relative overflow-hidden rounded object-none object-[59%_-4px]">
                        <Image
                            src="/bookstore-image.jpg"
                            alt="Picture of Book Store"
                            fill={true}
                        />
                    </div>
                    <div className="w-full">
                        <p className="font-bold">The Unforgiven </p>
                        <p>Price: {100}</p>
                        <div className="mt-2">
                            <span className="p-1 rounded bg-orange-300 hover:bg-orange-400 hover:cursor-pointer">Delete</span>
                        </div>
                    </div>
                </div>

            ))}

        </div>
        <div className="w-1/2 p-3 ml-3">
            <p className="mb-2">Enter Shipping Address:</p>
            <textarea className="w-3/4 h-14 rounded mb-2"></textarea>
            <p className="mb-2">Bill: 2250 taka</p>
            <p className="mb-2">Shipment: 120 taka</p>
            <p className="mb-3 font-bold">Total: 2370 taka</p>
            <span className="bg-orange-300 hover:bg-orange-400 p-2 rounded hover:cursor-pointer">Place Order</span>
        </div>
    </div>
  )
}
export default Cart