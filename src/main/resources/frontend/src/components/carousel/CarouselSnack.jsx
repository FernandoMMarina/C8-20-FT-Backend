import fries from '../../assets/images/Carousel/snack/fries.png';
import onions from '../../assets/images/Carousel/snack/onionRings.png';
import nuggets from '../../assets/images/Carousel/snack/nuggets.png';
import '../../css/carousel.css';


function Carousel2(){
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
      <img src={fries} class="d-block w-100 imgCarousel" alt="..." />
      <div class="carousel-caption d-none d-md-block">
        <h5 className='nameBurger'>Papas fritas XL</h5>
        <p className='descriptionCarousel'>Guarnicion de papas fritas XL</p>
      </div>
    </div>
    <div class="carousel-item">
      <img src={onions} class="d-block w-100 imgCarousel" alt="..." />
      <div class="carousel-caption d-none d-md-block nameAndDescriptionOfImg">
        <h5 className='nameBurger'>Aros de cebolla</h5>
        <p className='descriptionCarousel'>15 aros de cebolla super crocantes</p>
      </div>
    </div>
    <div class="carousel-item">
      <img src={nuggets} class="d-block w-100 imgCarousel" alt="..." />
      <div class="carousel-caption d-none d-md-block">
        <h5 className='nameBurger'>Nuggets de pollo</h5>
        <p className='descriptionCarousel'>20 nuggets de pollo Villain</p>
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

export default Carousel2;