import useSWR from "swr";
import Image from 'next/image'
import { Button } from "flowbite-react";
import { useState } from "react";
import { useAuth } from "@/app/contexts/AuthContext";
import { useRouter } from "next/navigation";


const link = "http://localhost:8081/books";
const fetcher = () => fetch(link).then(res => res.json())

const BookCards = () => {

    const [showMessage, setShowMessage] = useState(false)
    const { data, error, isLoading } = useSWR(link, fetcher)
    const {isLoggedin} = useAuth()
    // console.log(data)
    const router = useRouter()

    if(error) return <div>failed to load</div>
    if(isLoading) return <div>loading...</div>

    if(!data) return <div>no data</div>    

  return (
    <>
    {showMessage && (
        <div className="absolute z-50 top-0 w-1/2 translate-x-1/4 p-3  bg-orange-400 italic rounded text-center">
            Added to cart successfully
        </div>
    )}
    <div className="grid grid-cols-5 gap-3 mb-6">
        {data.map((book:any) => (            
            <div key={book.id}  className='bg-white hover:bg-orange-100 rounded text-center'>
                <div className="bg-cover h-32 relative overflow-hidden ">
                    <Image
                        src="/bookstore-image.jpg"
                        alt="Picture of Book Store"
                        fill={true}
                    />
                </div>
                <p>{book.name}</p>
                <p><span className="text-2xl">৳</span> {book.price}</p>
                <div className="bg-orange-300 rounded-b hover:cursor-pointer hover:bg-orange-400" onClick={()=>{
                    if(!isLoggedin){
                        router.push('/login')
                    }else
                    {
                        setShowMessage(true)
                        setTimeout(()=>{
                            setShowMessage(false)
                        }, 2000)
                    }
                }}>
                    Add to Cart
                </div>
            </div>
        ))}
    </div>
    </>

  )
}
export default BookCards