package com.github.ghcli.service.clients;

import com.github.ghcli.models.GitHubUser;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Interface to get the GitHub User.
 */
public interface IGitHubUser {

    @GET("user")
    Call<GitHubUser> getUser(@Header("Authorization") String credentials);

    @GET("user/followers")
    Call<List<GitHubUser>> getFollowers(@Header("Authorization") String credentials);

    @GET("user/following/{user}")
    Call<Void> isFollowing(@Header("Authorization") String credentials, @Path("user") String user);

    @PUT("user/following/{user}")
    Call<Void> follow(@Header("Authorization") String credentials, @Path("user") String user);

    @DELETE("user/following/{user}")
    Call<Void> unfollow(@Header("Authorization") String credentials, @Path("user") String user);
}
