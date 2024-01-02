import useSWR from "swr";
import Image from 'next/image'
import { Button } from "flowbite-react";


const link = "http://localhost:8081/books";
const fetcher = () => fetch(link).then(res => res.json())

const BookCards = () => {

    const { data, error, isLoading } = useSWR(link, fetcher)
    console.log(data)

    if(error) return <div>failed to load</div>
    if(isLoading) return <div>loading...</div>

    if(!data) return <div>no data</div>    

  return (
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
                <div className="bg-orange-300 rounded-b hover:cursor-pointer hover:bg-orange-400">
                    Add to Cart
                </div>
            </div>
        ))}
    </div>
  )
}
export default BookCards