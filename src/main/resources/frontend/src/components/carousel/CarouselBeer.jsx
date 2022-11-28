import beer1 from '../../assets/images/Carousel/beer/beerCorona.png';
import beer2 from '../../assets/images/Carousel/beer/beerBrahma.png';
import beer3 from '../../assets/images/Carousel/beer/beerStella.png';
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
      <img src={beer1} class="d-block w-100 imgCarousel" alt="..." />
      <div class="carousel-caption d-none d-md-block">
        <h5 className='nameBurger'> Cerveza Corona</h5>
        <p className='descriptionCarousel'>Refrescante cerveza Corona de 750ml</p>
      </div>
    </div>
    <div class="carousel-item">
      <img src={beer2} class="d-block w-100 imgCarousel" alt="..." />
      <div class="carousel-caption d-none d-md-block nameAndDescriptionOfImg">
        <h5 className='nameBurger'>Cerveza Brahma</h5>
        <p className='descriptionCarousel'>Lata de cerveza Brahma 900ml</p>
      </div>
    </div>
    <div class="carousel-item">
      <img src={beer3} class="d-block w-100 imgCarousel" alt="..." />
      <div class="carousel-caption d-none d-md-block">
        <h5 className='nameBurger'>Cerveza Stella Artois</h5>
        <p className='descriptionCarousel'>Refrescante cerveza Stella Artois 610ml</p>
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