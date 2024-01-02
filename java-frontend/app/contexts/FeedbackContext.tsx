import { ReactNode, createContext, useContext, useState } from "react";

type FeedbackType = {
    id: number;
    username: string;
    title: string;
    description: string;
    rating: number;
    date: string;
}

type feedbackContextType = { 
    feedbacks: FeedbackType[];
    feedbackRating: number;
    SetFeedbackRating: (rating:number) => void;
    SetFeedback: (newFeedback: FeedbackType[]) => void;

};


const FeedbackContextDefaultValues: feedbackContextType = {
    feedbacks: [],
    feedbackRating: 0,
    SetFeedbackRating: (rating:number) => {},
    SetFeedback: (newFeedback: FeedbackType[]) => {}
}

const FeedbackContext = createContext<feedbackContextType>(FeedbackContextDefaultValues);

export function useFeedback() {
    return useContext(FeedbackContext);
}

type Props = {
    children: ReactNode;
};

export function FeedbackProvider({ children }: Props) {
    const [feedbacks, setFeedback] = useState<FeedbackType[]>([])
    const [feedbackRating, setFeedbackRating] = useState<number>(0);


    const SetFeedback = (newFeedback: FeedbackType[]) => {
        setFeedback(newFeedback);
    }
    const SetFeedbackRating = (Rating:number) => {
        setFeedbackRating(Rating);
    }
    const value = {
        feedbacks,
        SetFeedback,
        feedbackRating,
        SetFeedbackRating,
    };

    return (
        
        <FeedbackContext.Provider value={value}>
            {children}
        </FeedbackContext.Provider>
        
    );
}