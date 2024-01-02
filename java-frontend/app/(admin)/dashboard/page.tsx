'use client'
import DashboardCards from "@/app/components/Admin/DashboardCards"
import { fetcher } from "@/app/components/Functions/Fetcher";
import MyLoading from "@/app/components/MyLoading";
import MySidebar from "@/app/components/MySidebar"
import useSWR from "swr"



const Dashboard = () => {
  const link = "http://localhost:3333/total";
  const { data, error, isLoading } = useSWR(link, () => fetcher(link));
    console.log(data)

    if(error) return <div>failed to load</div>
    if(isLoading) return (<MyLoading />)
    if(!data) return <div>no data</div> 
  return (
    <div className="grid grid-cols-3 gap-8 p-4">
       <DashboardCards value={data[0].customer} title="Total Customers" />
       <DashboardCards value={data[0].book} title="Total Books" />
       <DashboardCards value={data[0].order} title="Total Orders" />
       <DashboardCards value={data[0].revenue} title="Total Revenue" />
       <DashboardCards value={data[0].profit} title="Total Profit" />
       <DashboardCards value={data[0].cost} title="Total Cost" />
    </div>
  )
}
export default Dashboard