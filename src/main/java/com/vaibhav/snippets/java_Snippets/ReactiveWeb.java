package com.vaibhav.snippets.java_Snippets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ReactiveWeb {

    @Autowired
    private WebClient.Builder webClientBuilder;

    public static void main(String[] args) {
        ReactiveWeb instance = new ReactiveWeb();
        instance.callApi();
    }

    public void callApi() {
        Comics comics = webClientBuilder.build()
                .get()
                .uri("http://gateway.marvel.com/v1/public/comics?ts=125&apikey=d7fdda6390ffd12d5a17ed268454412e&hash=57b4639cf40d8795d83a055313faf7c4")
                .retrieve()
                .bodyToMono(Comics.class)
                .block();
        System.out.println(comics.toString());
        System.out.println("call successfully");
    }
}

class Comics {
    private String code;
    private String status;
    private String etag;

    @Override
    public String toString() {
        return "Comics{" +
                "code='" + code + '\'' +
                ", status='" + status + '\'' +
                ", etag='" + etag + '\'' +
                '}';
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEtag() {
        return etag;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }
}
