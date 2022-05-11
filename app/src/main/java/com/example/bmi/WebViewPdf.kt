

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.bmi.R
//import kotlinx.android.synthetic.main.fragment_webview_pdf.*


class WebViewPdfFragment : Fragment() {
}/*

    companion object {
        const val KEY_URL = "key_url"

        private const val PDF_VIEWER_URL = "https://docs.google.com/gview?embedded=true&url="
        private const val RELOAD_COUNT = "reload_count"
        private const val RELOAD_ALLOW = 6

        fun newInstance(url: String): WebViewPdfFragment {
            val fragment = WebViewPdfFragment()
            val args = Bundle()
            args.putString(KEY_URL, url)
            fragment.arguments = args
            return fragment
        }

    }

    private var url: String? = null
    private var reloadCount = 0

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_webview_pdf, container, false)

        url = arguments?.getString(KEY_URL)

        if (TextUtils.isEmpty(url)) {
            throw IllegalArgumentException("Empty URL passed to WebViewFragment!")
        }

        return view
    }
    val webView: WebView = findViewById(R.id.panelN)


    @SuppressLint("SetJavaScriptEnabled")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        savedInstanceState?.let {
            reloadCount = it.getInt(RELOAD_COUNT)
        }


        // Get the web view settings instance.
        val settings = webView.settings

        // Enable java script in web view.
        settings.javaScriptEnabled = true

        // Enable DOM storage API.
        settings.domStorageEnabled = true

        // Enable zooming in web view.
        settings.setSupportZoom(true)

        // Allow pinch to zoom.
        settings.builtInZoomControls = true

        // Disable the default zoom controls on the page.
        settings.displayZoomControls = false

        // Enable responsive layout.
        settings.useWideViewPort = false

        // Zoom out if the content width is greater than the width of the viewport.
        settings.loadWithOverviewMode = false


        // Set web view client.
        webView.webChromeClient = object : DefaultWebChromeClient() {

            override fun onProgressChanged(webView: WebView?, newProgress: Int) {
                if (newProgress < 100) {
                    progressBar.visibility = View.VISIBLE
                }
                if (newProgress == 100) {

                    // There is a bug with Google Docs that sometimes you get blank screen
                    // instead of a PDF file. To avoid just reload when you get it.
                    if (webView?.contentHeight == 0 && reloadCount < RELOAD_ALLOW) {
                        Log.w("LOG_TAG", "PDF loading error. Reloading $reloadCount.")
                        Toast.makeText(activity, "Error. Reloading...", Toast.LENGTH_SHORT).show()
                        reloadCount++
                        webView.reload()
                    }

                    progressBar.visibility = View.GONE
                }
            }

        }


        val urlString: String = PDF_VIEWER_URL + url

        webView.loadUrl(urlString)

        Log.d("LOG_TAG", "Loading URL: $url")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(RELOAD_COUNT, reloadCount)
        super.onSaveInstanceState(outState)
    }

    override fun onResume() {
        super.onResume()
        webView.onResume()
    }

    override fun onPause() {
        super.onPause()
        webView.onPause()
    }

    override fun onDestroyView() {
        super.onDestroyView()

        // Destroy the WebView completely.
        if (webView != null) {
            // The WebView must be removed from the view hierarchy before calling destroy to prevent a memory leak.
            (webView.parent as ViewGroup).removeView(webView)
            webView.removeAllViews()
            webView.destroy()
        }
    }


    fun onBackPressed(): Boolean {
        if (webView.canGoBack()) {
            // If web view have back history, then go to the web view back history.
            webView.goBack()
            return true
        }
        return false
    }


    internal open class DefaultWebViewClient : WebViewClient() {

        // Decide how a new url will be loaded. If this method returns false, it means current
        // webView will handle the url. If this method returns true, it means host application
        // will handle the url. By default, redirects cause jump from WebView to default
        // system browser.
        override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
            return true
        }

    }

    internal open class DefaultWebChromeClient : WebChromeClient() {

    }

} */