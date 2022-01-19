package Tests;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.MyList;
import Pages.ProductDetail;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

public class AmazonTest extends BaseTest {

    private HomePage homePage = null;
    private LoginPage loginPage=null;
    private ProductDetail productDetail=null;
    private MyList myList=null;

    @Before
    public void initTest() {
        homePage=PageFactory.initElements(driver, HomePage.class);
        loginPage=PageFactory.initElements(driver,LoginPage.class);
        productDetail=PageFactory.initElements(driver,ProductDetail.class);
        myList=PageFactory.initElements(driver,MyList.class);
    }

    @Test
    public void AmazonTest() {
        //Anasayfanın Açıldığı kontrol edilir
        Assert.assertEquals("https://www.amazon.com.tr/", homePage.getUrl());
        Assert.assertTrue(homePage.checkNavbar());
        //Çerez tercihlerinden Çerezleri kabul et görüntülenir
        homePage.acceptCookies();
        //Siteye Login olunur
        homePage.clickLogin();
        loginPage.setEmail(configLoader.getUsername());
        loginPage.clickContinue();
        loginPage.setPassword(configLoader.getPassword());
        loginPage.clickLogin();
        //Giriş yapıldığı kontrol edilir,eğer bu yazı yoksa giriş başarılı
        Assert.assertTrue("Login işlemi başarısız!?",homePage.checkIsLogin("Merhaba, Giriş yapın"));;
        //Arama butonu yanındaki kategoriler tabından bilgisayar seçilir.
        homePage.selectDropDown("Bilgisayarlar");
        //Arama alanına msi yazılır ,arama yapılır,arama yapıldığı kontrol edilir
        homePage.searchAndClickProduct("msi");
        Assert.assertTrue("Arama görüntülenemedi!", homePage.controlSearch());
        Assert.assertTrue("Sayfa bulunamadı!",homePage.getUrl().contains("/s?k=msi"));
        //Arama sonuçları sayfasından 2. sayfa açılır.
        homePage.scroolPage();
        homePage.clickPaginition("3");
        //2.sayfanın açıldığı kontrol edilir.
        homePage.scroolPage();
        Assert.assertTrue(homePage.paginationControl("2"));
        //Sayfadaki 2. ürün favorilere eklenir.
        homePage.scroolUpPage();
        homePage.wait(5);
        homePage.selectProduct();
        productDetail.createAndAdd("Favori Listem");
        // 2. Ürünün favorilere eklendiği kontrol edilir
        //Hesabım - Favori Listem sayfasına gidilir.
        myList.clickMyTab("Favori Listem");
        Assert.assertTrue(myList.checkProduct());
        //“Favori Listem” sayfası açıldığı kontrol edilir.
        Assert.assertTrue(myList.checkMyListPage("Favori Listem"));
        //Eklenen ürün favorilerden silinir.
        myList.deleteItem();
        //Silme işleminin gerçekleştiği kontrol edilir.
        Assert.assertTrue(myList.itemIsDelete());
        //Üye çıkış işlemi yapılır.
        myList.clickMyTab("Çıkış Yap");
        //Çıkış işleminin yapıldığı kontrol edilir.
        Assert.assertTrue(homePage.isSignOut());
    }
}
