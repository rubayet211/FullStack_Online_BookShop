'use client'

import { ReactNode, createContext, useContext, useState } from "react";

type ApplicationContextType = {  
    navbar: boolean;
    SetNavbar: (bool:boolean)  => void;
    bookname: string|null;
    SetBookname: (name:string|null) => void;
    bookprice: number|null;
    bookcost: number|null;
    SetBookprice: (price:number|null) => void;
    SetBookcost: (cost:number|null) => void;
    bookid: number|null;
    SetBookid: (id:number|null) => void;
};

const appContextDefaultValues: ApplicationContextType = { 
    navbar: false,
    SetNavbar: (bool:boolean) => {},
    bookname: null,
    SetBookname: (name:string|null) => {},
    bookprice: null,
    SetBookprice: (price:number|null) => {},
    bookcost: null,
    SetBookcost: (cost:number|null) => {},
    bookid: null,
    SetBookid: (id:number|null) => {}
};

const AppContext = createContext<ApplicationContextType>(appContextDefaultValues);

export function useApp() {
    return useContext(AppContext);
}

type Props = {
    children: ReactNode;
};

export function AppProvider({ children }: Props) {
    const [navbar, setNavbar] = useState(false)
    const SetNavbar = (bool:boolean) => {
        setNavbar(bool);
    }
    const [bookname, setBookname] = useState<string|null>(null)
    const SetBookname = (name:string|null) => {
        setBookname(name);
    }
    const [bookprice, setBookprice] = useState<number|null>(null)
    const SetBookprice = (price:number|null) => {
        setBookprice(price);
    }
    const [bookcost, setBookcost] = useState<number|null>(null)
    const SetBookcost = (cost:number|null) => {
        setBookcost(cost);
    }
    const [bookid, setBookid] = useState<number|null>(null)
    const SetBookid = (id:number|null) => {
        setBookid(id);
    }
    

    const value = {
        navbar,
        SetNavbar,
        bookname,
        SetBookname,
        bookprice,
        SetBookprice,
        bookcost,
        SetBookcost,
        bookid,
        SetBookid
    };
    return (
        <>
            <AppContext.Provider value={value}>
                {children}
            </AppContext.Provider>
        </>
    );
}