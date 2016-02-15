
package com.example.countries.domain;

import android.os.Parcel;
import android.os.Parcelable;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class Translations implements Parcelable {

    @SerializedName("de")
    @Expose
    private String de;
    @SerializedName("es")
    @Expose
    private String es;
    @SerializedName("fr")
    @Expose
    private String fr;
    @SerializedName("ja")
    @Expose
    private String ja;
    @SerializedName("it")
    @Expose
    private String it;

    /**
     * 
     * @return
     *     The de
     */
    public String getDe() {
        return de;
    }

    /**
     * 
     * @param de
     *     The de
     */
    public void setDe(String de) {
        this.de = de;
    }

    /**
     * 
     * @return
     *     The es
     */
    public String getEs() {
        return es;
    }

    /**
     * 
     * @param es
     *     The es
     */
    public void setEs(String es) {
        this.es = es;
    }

    /**
     * 
     * @return
     *     The fr
     */
    public String getFr() {
        return fr;
    }

    /**
     * 
     * @param fr
     *     The fr
     */
    public void setFr(String fr) {
        this.fr = fr;
    }

    /**
     * 
     * @return
     *     The ja
     */
    public String getJa() {
        return ja;
    }

    /**
     * 
     * @param ja
     *     The ja
     */
    public void setJa(String ja) {
        this.ja = ja;
    }

    /**
     * 
     * @return
     *     The it
     */
    public String getIt() {
        return it;
    }

    /**
     * 
     * @param it
     *     The it
     */
    public void setIt(String it) {
        this.it = it;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(de).append(es).append(fr).append(ja).append(it).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Translations) == false) {
            return false;
        }
        Translations rhs = ((Translations) other);
        return new EqualsBuilder().append(de, rhs.de).append(es, rhs.es).append(fr, rhs.fr).append(ja, rhs.ja).append(it, rhs.it).isEquals();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.de);
        dest.writeString(this.es);
        dest.writeString(this.fr);
        dest.writeString(this.ja);
        dest.writeString(this.it);
    }

    public Translations() {
    }

    protected Translations(Parcel in) {
        this.de = in.readString();
        this.es = in.readString();
        this.fr = in.readString();
        this.ja = in.readString();
        this.it = in.readString();
    }

    public static final Parcelable.Creator<Translations> CREATOR = new Parcelable.Creator<Translations>() {
        public Translations createFromParcel(Parcel source) {
            return new Translations(source);
        }

        public Translations[] newArray(int size) {
            return new Translations[size];
        }
    };
}
