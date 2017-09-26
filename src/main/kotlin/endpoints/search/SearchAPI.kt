package endpoints.search

import com.google.gson.reflect.TypeToken
import main.SpotifyAPI
import main.gson
import main.retrieveSomething
import main.toObject
import obj.*
import java.net.URLEncoder

class SearchAPI(api: SpotifyAPI) : Endpoint(api) {
    enum class SearchType(val id: String) {
        ALBUM("album"), TRACK("track"), ARTIST("artist"), PLAYLIST("playlist")
    }

    fun searchPlaylist(query: String, limit: Int = 20, offset: Int = 0, market: Market = Market.US): PlaylistPagingObject {
        return get("https://api.spotify.com/v1/search?q=${URLEncoder.encode(query, "UTF-8")}&type=${SearchType.PLAYLIST.id}&market=${market.code}&limit=$limit&offset=$offset")
                .removePrefix("{\n  \"${SearchType.PLAYLIST.id}s\" : ").removeSuffix("}").toObject()
    }

    fun searchArtist(query: String, limit: Int = 20, offset: Int = 0, market: Market = Market.US): ArtistPagingObject {
        return get("https://api.spotify.com/v1/search?q=${URLEncoder.encode(query, "UTF-8")}&type=${SearchType.ARTIST.id}&market=${market.code}&limit=$limit&offset=$offset")
                .removePrefix("{\n  \"${SearchType.ARTIST.id}s\" : ").removeSuffix("}").toObject()
    }

    fun searchAlbum(query: String, limit: Int = 20, offset: Int = 0, market: Market = Market.US): SimpleAlbumPagingObject {
        return get("https://api.spotify.com/v1/search?q=${URLEncoder.encode(query, "UTF-8")}&type=${SearchType.ALBUM.id}&market=${market.code}&limit=$limit&offset=$offset")
                .removePrefix("{\n  \"${SearchType.ALBUM.id}s\" : ").removeSuffix("}").toObject()
    }

    fun searchTrack(query: String, limit: Int = 20, offset: Int = 0, market: Market = Market.US): SimpleTrackPagingObject {
        return get("https://api.spotify.com/v1/search?q=${URLEncoder.encode(query, "UTF-8")}&type=${SearchType.TRACK.id}&market=${market.code}&limit=$limit&offset=$offset")
                .removePrefix("{\n  \"${SearchType.TRACK.id}s\" : ").removeSuffix("}").toObject()
    }
}