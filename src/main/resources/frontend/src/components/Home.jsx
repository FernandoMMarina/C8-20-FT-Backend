import { useState } from 'react';
import CarouselBurgers from './carousel/CarouselBurgers';
import CarouselBeer from './carousel/CarouselBeer';
import CarouselSnack from './carousel/CarouselSnack';
import beer from '../assets/images/iconOptions/beer.png';
import burger from '../assets/images/iconOptions/burger.png';
import snack from '../assets/images/iconOptions/snack.png';
import '../css/home.css';

function Home(){

    const [option, setOption] = useState(true)
    const [option2, setOption2] = useState(false)
    const [option3, setOption3] = useState(false)

    function handlerClick(){
        setOption(true)
        setOption2(false)
        setOption3(false)
       
    }

    function handlerClick2(){
        setOption2(true)
        setOption(false)
        setOption3(false)
    }

    function handlerClick3(){
        setOption3(true)
        setOption2(false)
        setOption(false)
    }


    return(
        <>
            <main>
                <div className='containerOptions'>
                    <div onClick={()=>{handlerClick()}}  ><img src={burger}  /></div>
                    <div onClick={()=>{handlerClick2()}} ><img src={snack} /></div>
                    <div onClick={()=>{handlerClick3()}} ><img src={beer} /></div>
                </div>
                <section>
                    {option && <CarouselBurgers />}
                    {option2 && <CarouselSnack />}
                    {option3 && <CarouselBeer />}
                </section>
            </main>
        </>
    )
}

export default Home;