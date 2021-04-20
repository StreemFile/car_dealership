import React, {useEffect, useState} from 'react';
import DealershipService from "../../service/DealershipService";

const DealershipById = (props) => {
    const [id,setId] = useState(props.dealershipId);
    const [dealership, setDealership] = useState({});

    useEffect(() => {
        setId(props.dealershipId);
        DealershipService.getById(id).then(result => setDealership(result.data))
    })

    return (
        <div>
            {dealership.city}
        </div>
    );
}

export default DealershipById;