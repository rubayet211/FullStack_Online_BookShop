'use client'
import DashboardCards from "@/app/components/Admin/DashboardCards"
import { fetcher } from "@/app/components/Functions/Fetcher";
import MyLoading from "@/app/components/MyLoading";
import MySidebar from "@/app/components/MySidebar"
import useSWR from "swr"



const Dashboard = () => {
  const link = "http://localhost:8081/dashboard";
  const { data, error, isLoading } = useSWR(link, () => fetcher(link));
    console.log(data)

    if(error) return <div>failed to load</div>
    if(isLoading) return (<MyLoading />)
    if(!data) return <div>no data</div> 
  return (
    <div className="grid grid-cols-3 gap-8 p-4">
       <DashboardCards value={data.customers} title="Total Customers" />
       <DashboardCards value={data.books} title="Total Books" />
       <DashboardCards value={data.orders} title="Total Orders" />
       <DashboardCards value={data.revenues} title="Total Revenue" />
       <DashboardCards value={data.profits} title="Total Profit" />
       <DashboardCards value={data.costs} title="Total Cost" />
    </div>
  )
}
export default Dashboard