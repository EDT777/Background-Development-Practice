<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   <!-- ##### Right Side Cart Area ##### -->
    <div class="cart-bg-overlay"></div>

    <div class="right-side-cart-area">

        <!-- Cart Button -->
        <div class="cart-button">
            <a href="#" id="rightSideCart"><img src="img/core-img/bag.svg" alt=""> <span>3</span></a>
        </div>

        <div class="cart-content d-flex">

            <!-- Cart List Area -->
            ${SHOPCART}111
            <div class="cart-list">
            <c:forEach items="${SHOPCART}" var="ci"> 
        
                <!-- Single Cart Item -->
                <div class="single-cart-item">
                    <a href="#" class="product-image">
                        <img src="<%=request.getContextPath()%>/img/product-img/product-1.jpg" class="cart-thumb" alt="">
                        <!-- Cart Item Desc -->
                        <div class="cart-item-desc">
                          <span class="product-remove"><i class="fa fa-close" aria-hidden="true"></i></span>
                            <span class="badge">Mango</span>
                            <h6>${ci.product.name}</h6>
                            <p class="size">Size: S</p>
                            <p class="color">数量:${ci.count}</p>
                            <p class="price">$${ci.product.price}</p>
                        </div>
                    </a>
                </div>
			</c:forEach>

            </div>

            <!-- Cart Summary -->
            <div class="cart-amount-summary">

                <h2>Summary</h2>
                <ul class="summary-table">
                    <li><span>总价格:</span> <span>$274.00</span></li>
                    <li><span>运费:</span> <span>免运费</span></li>
                    <li><span>折扣:</span> <span>-15%</span></li>
                    <li><span>总价:</span> <span>$232.00</span></li>
                </ul>
                <div class="checkout-btn mt-100">
                    <a href="checkout.jsp" class="btn essence-btn">结算</a>
                </div>
            </div>
        </div>
    </div>
    <!-- ##### Right Side Cart End ##### -->