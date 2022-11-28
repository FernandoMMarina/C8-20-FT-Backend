import burger1 from '../../assets/images/Carousel/burgers/burger1.png';
import burger2 from '../../assets/images/Carousel/burgers/burger2.png';
import burger3 from '../../assets/images/Carousel/burgers/burger3.png';
import '../../css/carousel.css';

function Carousel(){
    return(
        <>
        <div className="containerCarousel">
            <div id="carouselExampleCaptions" class="carousel slide" data-bs-ride="false">
  <div class="carousel-indicators">
    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1" aria-label="Slide 2"></button>
    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2" aria-label="Slide 3"></button>
  </div>
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img src={burger1} class="d-block w-100 imgCarousel" alt="..." />
      <div class="carousel-caption d-none d-md-block">
        <h5 className='nameBurger'> Extra Clasica</h5>
        <p className='descriptionCarousel'>Lechuga, tomate, cebolla, queso cheddar, pepinillos</p>
      </div>
    </div>
    <div class="carousel-item">
      <img src={burger2} class="d-block w-100 imgCarousel" alt="..." />
      <div class="carousel-caption d-none d-md-block nameAndDescriptionOfImg">
        <h5 className='nameBurger'>Especial Cheddar</h5>
        <p className='descriptionCarousel'>lechuga, tomate, doble cheddar, salsa especial</p>
      </div>
    </div>
    <div class="carousel-item">
      <img src={burger3} class="d-block w-100 imgCarousel" alt="..." />
      <div class="carousel-caption d-none d-md-block">
        <h5 className='nameBurger'>Chicken Burger</h5>
        <p className='descriptionCarousel'>lechuga, tomate, queso cheddar, panceta especial, salsa BBQ</p>
      </div>
    </div>
  </div>
  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Previous</span>
  </button>
  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Next</span>
  </button>
</div>
        </div>
        </>
    )
}

export default Carousel;